/*
 * Copyright 2020 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.customs.dit.licence.logging

import com.google.inject.Inject
import javax.inject.Singleton
import play.api.mvc.AnyContent
import uk.gov.hmrc.customs.api.common.logging.CdsLogger
import uk.gov.hmrc.customs.dit.licence.logging.LoggingHelper._
import uk.gov.hmrc.customs.dit.licence.model.ValidatedRequest

@Singleton
class LicencesLogger @Inject()(logger: CdsLogger) {

  def debug(msg: => String)(implicit validatedRequest: ValidatedRequest[AnyContent]): Unit = logger.debug(formatLog(msg, validatedRequest))
  def info(msg: => String)(implicit validatedRequest: ValidatedRequest[AnyContent]): Unit = logger.info(formatLog(msg, validatedRequest))
  def error(msg: => String)(implicit validatedRequest: ValidatedRequest[AnyContent]): Unit = logger.error(formatLog(msg, validatedRequest))
  def error(msg: => String, e: => Throwable)(implicit validatedRequest: ValidatedRequest[AnyContent]): Unit = logger.error(formatLog(msg, validatedRequest), e)
}
